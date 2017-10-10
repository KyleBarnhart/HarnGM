import { all, call, put, takeEvery, takeLatest } from 'redux-saga/effects';
import * as types from '../actions/actionTypes';

const fetchInit = {
    method: 'GET',
    headers: {
        'Accept': 'application/hal+json'
    },
    credentials: 'include'
};

function* fetchCharacters() {
    try {
        const response = yield call(fetch, "/api/characters", fetchInit);
        const data = yield response.json();
        const characters = data._embedded.characters;
        console.log(characters);
        yield put({type: types.CHARACTERS.FETCH.SUCCESS, payload: characters});
    } catch (error) {
        yield put({type: types.CHARACTERS.FETCH.FAILURE, payload: error, error: true});
    }
}

/*
  takeEvery
  Starts fetchUser on each dispatched `USER_FETCH_REQUESTED` action.
  Allows concurrent fetches of user.

  takeLatest
  Does not allow concurrent fetches of user. If "USER_FETCH_REQUESTED" gets
  dispatched while a fetch is already pending, that pending fetch is cancelled
  and only the latest one will be run.
*/
export default function* rootSaga() {
    yield all([
        fetchCharacters(),
        takeEvery(types.CHARACTERS.FETCH.REQUEST, fetchCharacters)
    ]);
    //yield takeLatest("USER_FETCH_REQUESTED", fetchUser);
}