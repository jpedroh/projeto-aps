import { useRouter } from "next/router";
import { Centered } from "../utils/Centered";
import Link from 'next/link';

export default function Criado() {
  const router = useRouter();

  return <Centered className="gap-4">
    <h1 className="text-2xl font-bold">Casa criada com sucesso!</h1>
    <h2>Utilize o código <b>{router.query.codigo}</b> para que seus amigos possam acessar a casa</h2>
    <Link href="/" className='bg-blue-400 p-2 px-6 rounded hover:bg-blue-300'>Voltar</Link>
  </Centered>
}