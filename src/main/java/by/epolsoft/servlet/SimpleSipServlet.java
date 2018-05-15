package by.epolsoft.servlet;

import by.epolsoft.utils.Database;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.sip.*;

public class SimpleSipServlet extends SipServlet implements TimerListener {
    private static Logger logger = Logger.getLogger(SimpleSipServlet.class.getSimpleName());


    public SimpleSipServlet() {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("the simple sip servlet has been started");
        super.init(servletConfig);
    }

    protected void doInvite(SipServletRequest request){
        logger.info("INVITE");
        String from = request.getFrom().getDisplayName();
        logger.info("From: "+from);
        String to = request.getTo().getDisplayName();
        logger.info("To: "+to);
        Database database = new Database(from);

    }


    public void timeout(ServletTimer servletTimer) {
    }
}