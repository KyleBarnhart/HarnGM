const createRequestTypes = (base) => ['FETCH', 'CREATE', 'UPDATE', 'DELETE']
    .reduce((action, type) => {
        action[type] = {};
        return ['REQUEST', 'SUCCESS', 'FAILURE'].reduce((action, status) => {
            action[type][status] = `${base}_${type}_${status}`;
            return action;
        }, action);
    }, {});

export const CHARACTERS = createRequestTypes('CHARACTERS');