const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  devServer: {
    port: 3001,// Replace 3001 with the desired port number
    // proxy: {
    //   '/api': {
    //     target: 'http://localhost:8080', // Replace with your Spring Boot backend URL
    //     ws: true,
    //     changeOrigin: true
    //   }
    // }
  }
};