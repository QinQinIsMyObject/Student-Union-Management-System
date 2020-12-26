import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import AppStore from './modules/AppStore.js';

export default new Vuex.Store({
  state: {
    // collapse: false  // 导航栏收缩状态
  },
  mutations: {
    // collapse(state) {  // 改变收缩状态
    //   state.collapse = !state.collapse;
    // }

    // 折叠导航栏
    // collapse: function () {
    //   $store.commit('collapse')
    // }
  },
  actions: {
  },
  modules: {
    app: AppStore
    // 其他
  }
})
