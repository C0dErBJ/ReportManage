package com.reportmanage.service.Impl;

import com.reportmanage.dao.TemplateMapper;
import com.reportmanage.model.Template;
import com.reportmanage.service.ITemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by C0dEr on 16/5/20.
 */
@Service("templateService")
public class TemplateImpl implements ITemplateService {
    @Resource
    private TemplateMapper mapper;

    public boolean addTemplate(Template model) {
        mapper.delete();
        return mapper.insert(model) > 0;
    }

    public Template getTemplate() {
        List<Template> list = mapper.selectAll();
        return list != null && list.size() > 0 ? list.get(0) : null;
    }
}
