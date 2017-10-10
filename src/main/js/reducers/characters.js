import * as types from '../actions/actionTypes';

const characters = (state = [], action) => {
    switch (action.type) {
        case types.CHARACTERS.FETCH.SUCCESS:
            return action.payload;
        default:
            return state;
    }
};

export default characters;