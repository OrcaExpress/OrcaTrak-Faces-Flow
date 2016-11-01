package com.orcatrak.faces.flow;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Orca Express
 */
public class Guest implements Serializable {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final long serialVersionUID = 1L;

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {

        String flowId = "guest";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();
        flowBuilder.viewNode("register-Id", "/" + flowId + "/register.xhtml");
        flowBuilder.viewNode("quote-Id", "/" + flowId + "/quote.xhtml");
        flowBuilder.viewNode( "success-Id", "/" + flowId + "/success.xhtml");
                            
        flowBuilder.returnNode("back-to-booking").fromOutcome("/booking.xhtml");

        flowBuilder.flowCallNode("startMembership").flowReference("", "member");

//        flowBuilder.flowCallNode("startMembership").flowReference("", "member").
//                outboundParameter()
        return flowBuilder.getFlow();

    }

}
