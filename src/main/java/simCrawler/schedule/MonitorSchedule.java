package simCrawler.schedule;

import simCrawler.config.MailConfig;
import simCrawler.mail.SIMMail;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class MonitorSchedule {
    //时间间隔
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public static void schedule() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, MailConfig.getHOUR(), MailConfig.getMINUTE(), MailConfig.getSECOND());
        SIMMail task = new SIMMail();
        Timer timer = new Timer();
        System.out.println("当前时间：" + new Date());
        timer.schedule(task, calendar.getTime(), PERIOD_DAY);
    }

    public static void main(String[] args) {
        schedule();
    }
}
