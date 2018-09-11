package design_model.Observer.subject;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/11
 * Time:20:20
 */
public class Hunter extends AbstractHR {
    @Override
    public void publishJob(String job) {
        allITalent.forEach(iTalent -> iTalent.newJob(job));
    }
}
