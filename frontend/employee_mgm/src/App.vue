<template>
  <div id="app">
    <navbarcomponent> </navbarcomponent>
    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Navbarcomponent from './components/layout/Navbar.vue'

export default {
  name: 'app',
  components: {
    'navbarcomponent': Navbarcomponent
  }
}
</script>

<style>
.main {
  margin-top: 80px;
  margin-bottom: 80px;
}

fieldset {
  border: 1px solid #2196F3 !important;
  margin: 0;
  xmin-width: 0;
  padding: 10px;
  position: relative;
  border-radius: 4px;
  background-color: white;
  padding-left: 10px!important;
}

legend {
  font-size: 14px;
  font-weight: bold;
  margin-bottom: 0px;
  width: 35%;
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px 5px 5px 10px;
  background-color: #BBDEFB;
}
</style>
