import { combineReducers } from 'redux';
import characters from './characters';

const characterApp = combineReducers({
    characters
});

export default characterApp