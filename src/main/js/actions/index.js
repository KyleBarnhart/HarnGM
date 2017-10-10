import * as types from './actionTypes';

export const characterFetchSuccess = characters => {
    return {
        type: types.CHARACTERS.FETCH.SUCCESS,
        payload: characters
    }
};

export const addCharacterSuccess = character => {
    return {
        type: types.CHARACTERS.UPDATE.SUCCESS,
        payload: character
    }
};

export const deleteCharacterSuccess = character => {
    return {
        type: types.CHARACTERS.DELETE.SUCCESS,
        payload: character
    }
};