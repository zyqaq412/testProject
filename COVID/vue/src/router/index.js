import VueRouter from "vue-router"
import student from '../view/student'
import school from '../view/school'
const router=new VueRouter({
    routes:[
        //配置路由的路径
        {
            path:'/student',
            component:student
        },
        {
            path:'/school',
            component:school
        }
    ]
})
export default router;