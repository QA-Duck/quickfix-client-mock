package akautdinov.fix.client.mock.fix;

import lombok.extern.slf4j.Slf4j;
import quickfix.*;

@Slf4j
public class FixSender implements Application {

    @Override
    public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound, IncorrectDataFormat,
            IncorrectTagValue, RejectLogon {
    }

    @Override
    public void fromApp(Message arg0, SessionID arg1) throws FieldNotFound, IncorrectDataFormat,
            IncorrectTagValue, UnsupportedMessageType { }

    @Override
    public void onCreate(SessionID arg0) {}

    @Override
    public void onLogon(SessionID arg0) {}

    @Override
    public void onLogout(SessionID arg0) {}

    @Override
    public void toAdmin(Message arg0, SessionID arg1) {}

    @Override
    public void toApp(Message msg, SessionID sessionId) throws DoNotSend {
        log.info("Sender toApp: " + msg.toString());
    }
}

