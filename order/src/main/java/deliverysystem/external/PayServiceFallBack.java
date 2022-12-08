package deliverysystem.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PayServiceFallBack implements PayService {
    private static Logger logger = LoggerFactory.getLogger(PayServiceFallBack.class);

    @Override
    public void acceptPay(Pay pay) {
        logger.error("Circuit breaker has been opened. Fallback returned instead.");
    }
}