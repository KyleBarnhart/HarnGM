const characters = (state = [], action) => {
    switch (action.type) {
        case 'ADD_CHARACTER':
            return [
                ...state,
                action.payload
            ];
        case 'DELETE_CHARACTER':
            return state.filter(item => action.payload !== item);
        default:
            return state
    }
};

export default characters