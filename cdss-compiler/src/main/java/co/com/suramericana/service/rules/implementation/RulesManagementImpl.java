package co.com.suramericana.service.rules.implementation;

import co.com.suramericana.exception.TechnicalException;
import co.com.suramericana.persistence.entity.JsonRule;
import co.com.suramericana.persistence.repository.JsonRuleRepository;
import co.com.suramericana.service.drl.DrlCompiler;
import co.com.suramericana.service.rules.RulesManagement;
import co.com.suramericana.service.versioncontrol.FileManagement;
import co.com.suramericana.service.versioncontrol.GitManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;

@Component
public class RulesManagementImpl implements RulesManagement {

    @Autowired
    private JsonRuleRepository jsonRuleRepository;

    @Autowired
    private DrlCompiler drlCompiler;

    @Autowired
    private GitManagement gitManagement;

    @Autowired
    private FileManagement fileManagement;

    @Override
    public void processRule(String idRule) {
        final String extension = ".drl";
        try {
            final Optional<JsonRule> jsonObject = jsonRuleRepository.findById(idRule);
            final String ruleJson = jsonObject.get().getRule()
                    .getSubString(1, (int) jsonObject.get().getRule().length());
            fileManagement.saveDrlFile(drlCompiler.compile(ruleJson), idRule + extension);
            gitManagement.synchronize();
        } catch (SQLException e) {
            throw new TechnicalException(e.getMessage(),e);
        }
    }
}
