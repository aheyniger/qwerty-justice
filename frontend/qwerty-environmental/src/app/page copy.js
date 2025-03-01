import Head from "next/head";

export default function Home() {
  return (
    <div className="relative h-screen w-screen bg-fixed bg-cover bg-center" style={{ backgroundImage: "url('/background.jpg')" }}>
      <Head>
        <title>Static Background Page</title>
      </Head>
      <div className="absolute inset-0 flex justify-center items-center">
        <div className="bg-white bg-opacity-80 rounded-lg shadow-lg p-6 max-w-2xl w-full h-3/4 overflow-y-auto">
          <h1 className="text-2xl font-bold mb-4">Scrollable Content</h1>
          <p className="mb-2">Lorem ipsum dolor sit amet, consectetur adipiscing elit...</p>
          <p className="mb-2">More content here...</p>
          <p className="mb-2">Even more content here...</p>
          <p className="mb-2">Keep scrolling!</p>
          <p className="mb-2">Almost there...</p>
          <p className="mb-2">And more!</p>
        </div>
      </div>
    </div>
  );
}