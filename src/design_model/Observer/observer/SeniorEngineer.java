package design_model.Observer.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/11
 * Time:19:38
 */
public class SeniorEngineer implements ITalent{
    private static final Logger LOG = LoggerFactory.getLogger(Architect.class);

    @Override
    public void newJob(String job) {
        LOG.info("SeniorEngineer get new position {}", job);
    }
}
