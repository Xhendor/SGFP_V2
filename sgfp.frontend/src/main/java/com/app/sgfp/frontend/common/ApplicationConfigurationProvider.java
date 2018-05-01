/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.frontend.common;


import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class ApplicationConfigurationProvider extends HttpConfigurationProvider
{


    @Override
    public Configuration getConfiguration(ServletContext context)
    {
        // Example bookstore configuration
        return ConfigurationBuilder.begin()
                // redirect to another page
                // Join a URL to an internal resource
                .addRule(Join.path("/app/login").to("/index.xhtml"))
                .addRule(Join.path("/app/content").to("/main.xhtml"))
                .addRule(Join.path("/index").to("index.xhtml"))
                ;
    }

    @Override
    public int priority()
    {
        return 0;
    }
}
