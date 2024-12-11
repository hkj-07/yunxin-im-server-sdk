package com.netease.nim.im.server.sdk.core.metrics;

import com.netease.nim.im.server.sdk.core.http.ContextType;
import com.netease.nim.im.server.sdk.core.http.HttpMethod;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;

import java.util.List;

/**
 * Created by caojiajun on 2024/12/10
 */
public class PrometheusConverter {

    public static String convert(Stats stats) {
        StringBuilder builder = new StringBuilder();
        builder.append("# HELP endpoint Stats\n");
        builder.append("# TYPE endpoint gauge\n");
        List<EndpointStats> endpointStatsList = stats.getEndpointStatsList();
        for (EndpointStats endpointStats : endpointStatsList) {
            String endpoint = endpointStats.getEndpoint();
            String result = endpointStats.getResult();
            long count = endpointStats.getCount();
            double avg = endpointStats.getAvg();
            double max = endpointStats.getMax();
            double p50 = endpointStats.getP50();
            double p75 = endpointStats.getP75();
            double p90 = endpointStats.getP90();
            double p99 = endpointStats.getP99();
            double p999 = endpointStats.getP999();
            builder.append(String.format("yunxin_im_sdk_endpoint_stats{endpoint=\"%s\",result=\"%s\",type=\"count\"} %d\n", endpoint, result, count));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"avg\"} %f\n", endpoint, result, avg));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"max\"} %f\n", endpoint, result, max));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"p50\"} %f\n", endpoint, result, p50));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"p75\"} %f\n", endpoint, result, p75));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"p90\"} %f\n", endpoint, result, p90));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"p99\"} %f\n", endpoint, result, p99));
            builder.append(String.format("command_spend_stats{command=\"%s\",result=\"%s\",type=\"p999\"} %f\n", endpoint, result, p999));
        }

        builder.append("# HELP uri Stats\n");
        builder.append("# TYPE uri gauge\n");
        List<UriStats> uriStatsList = stats.getUriStatsList();
        for (UriStats uriStats : uriStatsList) {
            String endpoint = uriStats.getEndpoint();
            HttpMethod method = uriStats.getMethod();
            ApiVersion apiVersion = uriStats.getApiVersion();
            ContextType contextType = uriStats.getContextType();
            String uri = uriStats.getUri();
            String result = uriStats.getResult();
            long count = uriStats.getCount();
            double avg = uriStats.getAvg();
            double max = uriStats.getMax();
            double p50 = uriStats.getP50();
            double p75 = uriStats.getP75();
            double p90 = uriStats.getP90();
            double p99 = uriStats.getP99();
            double p999 = uriStats.getP999();
            builder.append(String.format("yunxin_im_sdk_endpoint_stats{endpoint=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"count\"} %d\n",
                    endpoint, method, apiVersion, contextType, uri, result, count));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"avg\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, avg));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"max\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, max));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"p50\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, p50));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"p75\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, p75));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"p90\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, p90));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"p99\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, p99));
            builder.append(String.format("command_spend_stats{command=\"%s\",method=\"%s\",api_version=\"%s\",context_type=\"%s\",uri=\"%s\",result=\"%s\",type=\"p999\"} %f\n",
                    endpoint, method, apiVersion, contextType, uri, result, p999));
        }

        return builder.toString();
    }
}