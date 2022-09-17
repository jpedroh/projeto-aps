import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import type { NextPage } from 'next';
import Head from 'next/head';
import Image from 'next/image';
import styles from '../styles/Home.module.css';
import { Centered } from '../utils/Centered';

const Home: NextPage = () => {
  const user = useQuery(['users', 'me'], () => {
    return axios.get('http://localhost:3000/users/me', {
      withCredentials: true
    }).then(r => r.data)
  })

  if (user.isLoading) {
    return <Centered>Carregando...</Centered>
  }

  if (user.isError) {
    return <Centered>Um erro ocorreu 🙁</Centered>
  }

  return (
    <Centered className={styles.container}>
      <h1 className={styles.title}>
        Olá, {user.data.nome}! 👋
      </h1>
    </Centered>
  )
}

export default Home
