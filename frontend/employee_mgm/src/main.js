// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router';
import App from './App'
import BootstrapVue from 'bootstrap-vue';

//routes
import { approutes } from './app-routes'

Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(BootstrapVue)

const approuter = new VueRouter({
  routes: approutes,
  mode: 'history',
  saveScrollPosition: true
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  router: approuter,
  components: { App }
})
