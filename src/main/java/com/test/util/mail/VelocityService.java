package com.test.util.mail;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Created by Marcio Ballem on 05/08/2014.
 */
@Service("velocityService")
public class VelocityService {

    private static final String ENCODING = "UTF-8";
    
    @Autowired
    private VelocityEngine velocityEngine;

    private Map<String, Object> model = new HashMap<String, Object>();

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getVelocityBody(String templateUrl) {
        return VelocityEngineUtils.mergeTemplateIntoString(
                this.velocityEngine,
                templateUrl,
                ENCODING,
                this.model
        );
    }
}