// es6语法引入mock模块
import Mock from 'mockjs';

Mock.mock('http://localhost:8080/login', {
    data: {
        'token': '4344323424398'
    },
})

Mock.mock('http://localhost:8080/user', {
    'name': '@name',
    'email': '@email',
    'age|1-10': 5
});

Mock.mock('http://localhost:8080/menu', {
    'id': '@increment',
    'name': 'menu',
    'order|10-20': 12
});
