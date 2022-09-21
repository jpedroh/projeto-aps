import { FC, ReactNode } from "react";

export const Centered: FC<{ children: ReactNode, className?: string }> = ({ children, className = '' }) => {
  return <div className={`flex flex-col items-center justify-center min-h-screen ${className}`}>
    {children}
  </div>
}