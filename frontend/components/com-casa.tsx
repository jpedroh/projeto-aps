import Image from 'next/image';
import financas from '../components/financas.png';
import tarefas from '../components/tarefas.png';
import { useUserHome } from '../hooks/useUserHome';

export function ComCasa() {
  const userHome = useUserHome()

  return <div className='flex flex-col gap-6'>
    <h2 className='text-2xl border border-black rounded-lg p-4 w-full text-center'>Casa {userHome.data.nome}</h2>

    <div className='flex gap-6'>
      <div className='border p-6 flex flex-col gap-4 border-black rounded-xl'>
        <div className='self-center'><Image src={tarefas} width={30} height={30} /></div>
        <button className='bg-blue-400 p-3 px-10 rounded hover:bg-blue-300'>Ver Tarefas</button>
        <button className='bg-blue-400 p-3 px-10 rounded hover:bg-blue-300'>Nova Tarefa</button>
      </div>
      <div className='border p-6 flex flex-col gap-4 border-black rounded-xl'>
        <div className='self-center'><Image src={financas} width={30} height={30} /></div>
        <button className='bg-blue-400 p-3 px-10 rounded hover:bg-blue-300'>Ver Finanças</button>
        <button className='bg-blue-400 p-3 px-10 rounded hover:bg-blue-300'>Nova Finança</button>
      </div>
    </div>
  </div>
}