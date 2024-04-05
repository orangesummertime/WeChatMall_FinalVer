const base = {
    get() {
        return {
            url : "http://localhost:8080/lingshipifajiaoyi/",
            name: "lingshipifajiaoyi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lingshipifajiaoyi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "焊割精工商品交易管理系统",
        }
    }
}
export default base
