package com.gyd.controller;

import com.gyd.dto.EsDto;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.DateUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class EsController {

    //索引名称
    private String indexName = "my_index";

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RestHighLevelClient restHighLevelClient;
    @GetMapping("/flushIndex")
    @ApiOperation("重建索引,并初始化全量数据")
    public String flushIndex() {
        try {
            //1、删除索引(若有)
            GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
            boolean indexExists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
            if (indexExists){
                DeleteIndexRequest request = new DeleteIndexRequest(indexName);
                AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
                if (!delete.isAcknowledged()) {
                    throw new RuntimeException("索引删除失败");
                }
            }

            String indexConfig = readIndexConfigFromJsonFile();
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            request.mapping("_doc",indexConfig, XContentType.JSON);
            // 2、新建索引
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();
            if (!(acknowledged && shardsAcknowledged)) {
                throw new RuntimeException("索引创建失败");
            }

            //3、插入全量数据
            BulkRequest bulkRequest = new BulkRequest();
            List<EsDto> dataList = new ArrayList<>();
            dataList.add(new EsDto(1L, "张三", "13762827777", DateUtils.parseDate("2023-06-29 19:46:25"),DateUtils.parseDate("2023-06-29 19:46:25"),"上海市xx", 11));
            dataList.add(new EsDto(2L, "李四", "13762827778", DateUtils.parseDate("2021-06-29 19:46:25"),DateUtils.parseDate("2023-06-29 19:46:25"),"上海市xx", 12));
            dataList.add(new EsDto(3L, "王五", "13762827779", DateUtils.parseDate("2019-06-29 19:46:25"),DateUtils.parseDate("2023-06-29 19:46:25"),"浙江省xx", 13));
            for (EsDto esDto : dataList) {
                // 创建请求 规则:put /comparison-tools/_doc/1
                IndexRequest indexRequest = new IndexRequest(indexName,"_doc",String.valueOf(esDto.getId()));
                // 将我们的数据放入请求 json
                indexRequest.source(esDto, XContentType.JSON);
                bulkRequest.add(indexRequest);
            }
            bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            BulkResponse response = restHighLevelClient.bulk(bulkRequest,RequestOptions.DEFAULT);
            if (response.hasFailures()) {
               return "批量导入文档失败,"+response.buildFailureMessage();
            } else {
                return "成功导入"+response.getItems().length+"个文档";
            }
        }catch (Exception e){
            return "索引创建失败"+e.getMessage();
        }
    }


    public String readIndexConfigFromJsonFile() throws IOException {
        Resource resource = applicationContext.getResource("classpath:es.json");
        InputStream inputStream = resource.getInputStream();

        String indexConfig = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));
        return indexConfig;
    }
}
