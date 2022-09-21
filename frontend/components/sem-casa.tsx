import { FormEvent } from "react";
import { useCriarCasa } from "../hooks/useCriarCasa";
import { useEntrarCasa } from "../hooks/useEntrarCasa";

export function SemCasa() {
  const criarCasa = useCriarCasa();
  const entrarCasa = useEntrarCasa();

  function handleSubmit<T>(action: (x: T) => void) {
    return function (evt: FormEvent<HTMLFormElement>) {
      evt.preventDefault()
      return action(Object.fromEntries(new FormData(evt.target as any)) as T)
    }
  }

  return <div className='flex flex-col items-center'>
    <h2 className='text-2xl'>Não conseguimos encontrar nenhuma casa que você fizesse parte</h2>
    <div className='flex gap-6'>
      <div className='flex flex-col gap-4 p-6 rounded-xl'>
        <h3 className='text-xl text-center font-semibold'>Criar uma casa</h3>
        <form className='flex flex-col gap-2' onSubmit={handleSubmit(criarCasa.mutate)}>
          <input className='border border-black p-2 rounded' placeholder='Nome da casa' name="nome" required />
          <button disabled={criarCasa.isLoading} className='bg-blue-400 p-2 rounded hover:bg-blue-300'>Criar casa</button>
        </form>
      </div>
      <div className='flex flex-col gap-4 p-6 rounded-xl'>
        <h3 className='text-xl text-center font-semibold'>Entrar numa casa existente</h3>
        <form className='flex flex-col gap-2' onSubmit={handleSubmit(entrarCasa.mutate)}>
          <input className='border border-black p-2 rounded' placeholder='Código da casa' name="codigo" required />
          <button className='bg-blue-400 p-2 rounded hover:bg-blue-300'>Entrar na casa</button>
        </form>
      </div>
    </div>
  </div>
}