package design_model.Observer.subject;

import design_model.Observer.observer.ITalent;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/11
 * Time:20:11
 */
public abstract class AbstractHR {
    protected Collection<ITalent> allITalent = new ArrayList<>();

    public abstract void publishJob(String job);

    public void addITalent(ITalent iTalent){
        allITalent.add(iTalent);
    }

    public void removeITalent(ITalent iTalent){
        allITalent.remove(iTalent);
    }
}
