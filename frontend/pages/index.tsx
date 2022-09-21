import type { NextPage } from 'next';
import { ComCasa } from '../components/com-casa';
import { SemCasa } from '../components/sem-casa';
import { useUser } from '../hooks/useUser';
import { useUserHome } from '../hooks/useUserHome';
import styles from '../styles/Home.module.css';
import { Centered } from '../utils/Centered';

const Home: NextPage = () => {
  const user = useUser();
  const userHome = useUserHome();

  if (user.isLoading || userHome.isLoading) {
    return <Centered>Carregando...</Centered>
  }

  if (user.isError || userHome.isError) {
    return <Centered>Um erro ocorreu 🙁</Centered>
  }

  return (
    <Centered className={`${styles.container} gap-4 w-10/12 mx-auto`}>
      <h1 className={'text-4xl font-semibold'}>
        Olá, {user.data.nome}! 👋
      </h1>
      {userHome.data ? <ComCasa /> : <SemCasa />}
    </Centered>
  )
}

export default Home
