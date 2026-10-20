package com.github.avor42.saga.participant.model;

import com.github.avor42.saga.participant.model.enums.SagaStepActionStatus;
import com.github.avor42.saga.participant.model.enums.SagaStepActionType;

/**
 * @author Voronkov A
 * @since 18.10.2026
 */
public record SagaStepActionReply<ID, S>(
        ID sagaId,
        String sagaName,
        S step,
        SagaStepActionType sagaStepActionType,
        SagaStepActionStatus sagaStepActionStatus
) {

}