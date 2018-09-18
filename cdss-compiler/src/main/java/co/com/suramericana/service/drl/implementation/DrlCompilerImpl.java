package co.com.suramericana.service.drl.implementation;

import co.com.suramericana.Application;
import co.com.suramericana.domain.Parameter;
import co.com.suramericana.persistence.repository.JsonRuleRepository;
import co.com.suramericana.service.drl.DrlCompiler;
import co.com.suramericana.service.json.JsonParser;
import co.com.suramericana.service.versioncontrol.GitManagement;
import org.drools.template.ObjectDataCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

import java.util.List;


@Component
public class DrlCompilerImpl implements DrlCompiler {

    @Autowired
    private JsonRuleRepository jsonRuleRepository;

    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private GitManagement gitManagement;


    @Override
    public String compile(String jsonRule) {
        final List<Parameter> parameters = jsonParser.stringToParameters(jsonRule);
        final ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
        return objectDataCompiler.compile(parameters, getTemplate());
    }

    private static InputStream getTemplate() {
        return Application.class.getResourceAsStream("rule-template.drt");
    }
}
