import { defineConfig } from 'vite'

export default defineConfig({
  // map @/* to ./lib/*
  resolve: {
    alias: {
      '@': '/lib',
    },
  },
})
