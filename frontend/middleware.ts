import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

const PROTECTED_PATHS = [
  '/'
]

export function middleware(request: NextRequest) {
  const hasToken = request.cookies.has('email');

  if (request.nextUrl.toString().includes('login')) {
    return NextResponse.next();
  }

  if (PROTECTED_PATHS.includes(request.nextUrl.pathname) && !hasToken) {
    return NextResponse.redirect(new URL("/login", request.url));
  }

  return NextResponse.next();
}

export const config = {
  matcher: '/:path*',
}
