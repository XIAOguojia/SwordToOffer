package design_model.Observer.test;

import design_model.Observer.observer.Architect;
import design_model.Observer.observer.ITalent;
import design_model.Observer.observer.JuniorEngineer;
import design_model.Observer.observer.SeniorEngineer;
import design_model.Observer.subject.AbstractHR;
import design_model.Observer.subject.Hunter;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/9/11
 * Time:20:22
 */
public class Client {
    public static void main(String[] args) {
        ITalent juniorEngineer = new JuniorEngineer();
        ITalent seniorEngineer = new SeniorEngineer();
        ITalent architect = new Architect();

        AbstractHR hunter = new Hunter();
        hunter.addITalent(juniorEngineer);
        hunter.addITalent(seniorEngineer);
        hunter.addITalent(architect);
        hunter.publishJob("Java 后台开发工程师");
    }
}
