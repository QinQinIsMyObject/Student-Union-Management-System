<template>
  <div class="page">
    <h2>Home Page</h2>
    <el-button type="primary" @click="testAxios()">测试axios调用</el-button>
    <el-button type="primary" @click="getUser()">获取用户信息</el-button>
    <el-button type="primary" @click="getMenu()">获取菜单信息</el-button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Home",
  methods: {
    testAxios() {
      axios
        .get("http://localhost:8080")
        .then(function (res) {
          alert(res.data);
        })
        .catch(function (res) {
          alert(res);
        });
    },
  },
};
</script>
