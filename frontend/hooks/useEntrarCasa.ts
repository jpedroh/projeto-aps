import { useMutation, useQueryClient } from "@tanstack/react-query"
import axios from "axios"

export function useEntrarCasa() {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: (data: { codigo: string }) => {
      return axios.post(`http://localhost:3000/casas/${data.codigo}/entrar`, {}, { withCredentials: true }).then(r => r.data)
    },
    onSuccess: () => queryClient.invalidateQueries(['users', 'me', 'home'])
  })
}