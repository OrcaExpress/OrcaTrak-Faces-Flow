package com.orcatrak.faces.flow;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import org.slf4j.LoggerFactory;

public class Member implements Serializable {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final long serialVersionUID = 1L;

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {

        String flowId = "member";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.returnNode("back-to-booking").fromOutcome("/booking.xhtml");
        
        flowBuilder.flowCallNode("back-to-guest").flowReference("", "guest"); // this is working but i dont like the outcome a member should not be treated as a guest 
//        flowBuilder.flowCallNode("back-to-guest").flowReference("quote-Id", "/guest/quote.xhtml");   <--------------- i tried this and its not working 
//        flowBuilder.returnNode("quote-Id").fromOutcome("/guest/quote.xhtml"); <--------------------------------- i tried this and its not working 
        return flowBuilder.getFlow();
    }
}
