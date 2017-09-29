export const addCharacter = character => {
    return {
        type: 'ADD_CHARACTER',
        payload: character
    }
};

export const deleteCharacter = character => {
    return {
        type: 'DELETE_CHARACTER',
        payload: character
    }
};