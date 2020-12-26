<template>
  <el-form
    :model="loginForm"
    :rules="fieldRules"
    ref="loginForm"
    label-position="left"
    label-width="0px"
    class="demo-ruleForm login-container"
  >
    <h3 class="title">系统登录</h3>
    <el-form-item prop="account">
      <el-input
        type="text"
        v-model="loginForm.account"
        auto-complete="off"
        placeholder="账号"
      ></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input
        type="password"
        v-model="loginForm.password"
        auto-complete="off"
        placeholder="密码"
      ></el-input>
    </el-form-item>
    <!-- <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox> -->
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 48%" @click.native.prevent="reset"
        >重 置</el-button
      >
      <el-button
        type="primary"
        style="width: 48%"
        @click.native.prevent="login"
        :loading="logining"
        >登 录</el-button
      >
    </el-form-item>
  </el-form>
</template>

<script>
// import mock from "@/mock/mock.js";
import mock from "@/mock/index.js";

import Cookies from "js-cookie";
import router from "@/router";

export default {
  name: "Login",
  methods: {
    login() {
      this.$api
        .login()
        .then(function (res) {
          alert(res.data.token);
          Cookies.set("token", res.data.token); // 放置token到Cookie
          router.push("/"); // 登录成功，跳转到主页
        })
        .catch(function (res) {
          alert(res);
        });
    },
  },
};
</script>
