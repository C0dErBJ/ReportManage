package com.reportmanage.service;

import com.reportmanage.model.Template;

/**
 * Created by C0dEr on 16/5/20.
 */
public interface ITemplateService {
    boolean addTemplate( Template model);

    Template getTemplate();
}
