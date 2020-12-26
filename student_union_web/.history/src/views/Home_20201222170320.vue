<template>
  <el-row class="container">
    <el-col :span="24" class="header">
      <el-col
        :span="5"
        class="logo"
        :class="isCollapse ? 'logo-collapse-width' : 'logo-width'"
      >
        <img :src="this.logo" /> {{ isCollapse ? sysName : sysName }}
      </el-col>
      <el-col :span="1">
        <div class="tools" @click.prevent="collapse">
          <i class="el-icon-menu"></i>
        </div>
        <!-- <i class="fa fa-align-justify"></i> -->
      </el-col>
      <el-col :span="13">
        <div class="hearNavBar">
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            background-color="#4b5f6e"
            text-color="#fff"
            active-text-color="#ffd04b"
            mode="horizontal"
            @select="handleSelectHearNavBar"
          >
            <el-menu-item index="1">首页</el-menu-item>
            <el-menu-item index="2">消息中心</el-menu-item>
            <el-menu-item index="3">订单管理</el-menu-item>
          </el-menu>
        </div>
      </el-col>
      <el-col :span="5" class="userinfo">
        <el-dropdown trigger="hover">
          <span class="el-dropdown-link userinfo-inner"
            ><img :src="this.userAvatar" /> {{ username }}</span
          >
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>我的消息</el-dropdown-item>
            <el-dropdown-item>设置</el-dropdown-item>
            <el-dropdown-item divided @click.native="logout"
              >退出登录</el-dropdown-item
            >
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </el-col>
    <el-col :span="24" class="main">
      <aside class="aside">
        <!--导航菜单-->
        <el-menu
          default-active="1-3"
          class="el-menu-vertical-demo"
          @open="handleopen"
          @close="handleclose"
          @select="handleselect"
          :collapse="isCollapse"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">系统管理</span>
            </template>
            <el-menu-item index="1-1" @click="$router.push('user')"
              >用户管理</el-menu-item
            >
            <el-menu-item index="1-2" @click="$router.push('menu')"
              >菜单管理</el-menu-item
            >
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu>
      </aside>
      <section class="content-container">
        <div class="grid-content bg-purple-light">
          <el-col :span="24" class="breadcrumb-container">
            <el-breadcrumb separator="/" class="breadcrumb-inner">
              <el-breadcrumb-item
                v-for="item in $route.matched"
                :key="item.path"
              >
                {{ item.name }}
              </el-breadcrumb-item>
            </el-breadcrumb>
          </el-col>
          <el-col :span="24" class="content-wrapper">
            <transition name="fade" mode="out-in">
              <router-view></router-view>
            </transition>
          </el-col>
        </div>
      </section>
    </el-col>
  </el-row>
</template>

<script>
import axios from "axios";

// import mock from "@/mock/mock.js";
import mock from "@/mock/index.js";

export default {
  methods: {
    getUser() {
      axios
        .get("http://localhost:8080/user")
        .then(function (res) {
          alert(JSON.stringify(res.data));
        })
        .catch(function (res) {
          alert(res);
        });
    },
    getMenu() {
      axios
        .get("http://localhost:8080/menu")
        .then(function (res) {
          alert(JSON.stringify(res.data));
        })
        .catch(function (res) {
          alert(res);
        });
    },
  },
  //折叠导航栏
  collapse: function () {
    this.isCollapse = !this.isCollapse;
  },
  // 退出登录
  logout: function () {
    var _this = this;
    this.$confirm("确认退出吗？", "提示", {
      type: "warning",
    })
      .then(() => {
        sessionStorage.removeItem("user");
        this.$router.push("/login");
      })
      .catch(() => {});
  },
  mounted() {
    (this.sysName = "Kitty"), (this.logo = require("@/assets/logo.png"));
    var user = sessionStorage.getItem("user");
    if (user) {
      this.userName = user;
      this.userAvatar = require("@/assets/user.png");
    }
  },
};
</script>
