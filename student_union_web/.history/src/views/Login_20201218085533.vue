<el-button type="primary" @click="getUser()">获取用户信息</el-button>
<el-button type="primary" @click="getMenu()">获取菜单信息</el-button>

<script>
import mock from "@/mock/mock.js";
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
};
</script>
