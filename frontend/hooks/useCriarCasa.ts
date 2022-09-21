import { useMutation } from "@tanstack/react-query";
import axios from "axios";
import { useRouter } from "next/router";

export function useCriarCasa() {
  const router = useRouter();

  return useMutation({
    mutationFn: (data: { codigo: string }) => {
      return axios.post<{ codigo: string }>('http://localhost:3000/casas', data, { withCredentials: true }).then(r => r.data)
    },
    onSuccess: (data) => router.push(`/criado?codigo=${data.codigo}`)
  })
}