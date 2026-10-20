package com.github.avor42.saga.participant.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.avor42.saga.participant.model.SagaStepAction;
import com.github.avor42.saga.participant.model.SagaStepActionReply;
import com.github.avor42.saga.participant.model.enums.SagaStepActionStatus;

/**
 * @author Voronkov A
 * @since 18.10.2026
 */
public abstract class SagaStepActionProvider<ID, S, C> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public void execute(SagaStepAction<ID, S, C> sagaStepAction) {
        try {
            executeStepAction(sagaStepAction);
            SagaStepActionReply<ID, S> sagaStepActionReply = createReply(sagaStepAction, SagaStepActionStatus.SUCCESS);
            sendReply(sagaStepActionReply);
        } catch (Exception e) {
            handleExecutionException(e);
            SagaStepActionReply<ID, S> sagaStepActionReply = createReply(sagaStepAction, SagaStepActionStatus.FAILURE);
            sendReply(sagaStepActionReply);
        }
    }

    public void compensate(SagaStepAction<ID, S, C> sagaStepAction) {
        try {
            compensateStepAction(sagaStepAction);
            SagaStepActionReply<ID, S> sagaStepActionReply = createReply(sagaStepAction, SagaStepActionStatus.SUCCESS);
            sendReply(sagaStepActionReply);
        } catch (Exception e) {
            handleCompensationException(e);
            SagaStepActionReply<ID, S> sagaStepActionReply = createReply(sagaStepAction, SagaStepActionStatus.FAILURE);
            sendReply(sagaStepActionReply);
        }
    }

    protected abstract void executeStepAction(SagaStepAction<ID, S, C> sagaStepAction);

    protected abstract void compensateStepAction(SagaStepAction<ID, S, C> sagaStepAction);

    protected abstract void sendReply(SagaStepActionReply<ID, S> sagaStepActionReply);

    protected void handleExecutionException(Exception e) {
        log.error(e.getMessage(), e);
    }

    protected void handleCompensationException(Exception e) {
        log.error(e.getMessage(), e);
    }

    private SagaStepActionReply<ID, S> createReply(SagaStepAction<ID, S, C> sagaStepAction, SagaStepActionStatus sagaStepActionStatus) {
        return new SagaStepActionReply<>(sagaStepAction.sagaId(),
                sagaStepAction.sagaName(),
                sagaStepAction.step(),
                sagaStepAction.sagaStepActionType(),
                sagaStepActionStatus);
    }

}
