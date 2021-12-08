import thunk from "redux-thunk";
import rootReducer from "./reducers";
import { createStore, applyMiddleware, compose } from "redux";

const initialState = {};
const middleware = [thunk];

let store;

if (window.navigator.userAgent.includes("Chrome")) {
  store = createStore(
    rootReducer,
    intialState,
    compose(applyMiddleware(...middleware))
  );
} else {
}

export default store;
