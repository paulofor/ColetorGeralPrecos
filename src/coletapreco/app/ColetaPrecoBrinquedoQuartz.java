package coletapreco.app;

import static org.quartz.CronScheduleBuilder.dailyAtHourAndMinute;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.log.ArquivoLog;





public class ColetaPrecoBrinquedoQuartz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//VerificadorInteresseNovo();
		//ExecutadorNotificacao();

		ColetaPrecoBrinquedoObj obj = new ColetaPrecoBrinquedoObj();
		SchedulerFactory sf = new StdSchedulerFactory();
        try {
            Scheduler sched = sf.getScheduler();
            JobDetail job1 = newJob(ColetaPrecoBrinquedoObj.class)
                .withIdentity("job1", "group1")
                .build();
            System.out.println("Criando Job");
            System.out.println("Versão de " + ColetaPrecoBrinquedoApp.getDataVersao());
            CronTrigger trigger1 = newTrigger()
                .withIdentity("trigger1", "group1")
                //.withSchedule(dailyAtHourAndMinute(14,51))
                .withSchedule(dailyAtHourAndMinute(4,30))
                .forJob(job1)
                .build();
            
           sched.scheduleJob(job1, trigger1);

           sched.start();

        } catch (SchedulerException se) {
        	ArquivoLog.getInstancia().salvaErro(se);
            se.printStackTrace();
        }

	}
	
	

}
