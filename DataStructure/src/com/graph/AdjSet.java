package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @�ٷ���վ : https://douma.ke.qq.com
 * @΢�Ź��ں� : �������
 * @�ٷ�΢�ź� : bigdatatang01
 * @���� : ����
 */
// �ռ临�Ӷȣ�O(V + E)
public class AdjSet implements Graph {
    private int V; // ����ĸ���
    private int E; // �ߵĸ���
    private TreeSet<Integer>[] adj; // �ڽӱ�

    // ��ͼʱ�临�Ӷȣ�O(E*logV)
    public AdjSet(String fileName) {
        try {
            BufferedReader reader
                    = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String[] arr = line.split(" ");
            this.V = Integer.valueOf(arr[0]);
            this.E = Integer.valueOf(arr[1]);

            this.adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<>();
            }
            while ((line = reader.readLine()) != null) { // O(E)
                arr = line.split(" ");
                int a = Integer.valueOf(arr[0]);
                validateVertex(a);
                int b = Integer.valueOf(arr[1]);
                validateVertex(b);
                // ����Ի���
                if (a == b) {
                    throw new RuntimeException("�������Ի��ߣ�����");
                }
                // ���ƽ�б�
                if (adj[a].contains(b)) { // O(logV)
                    throw new RuntimeException("������ƽ�бߣ�����");
                }
                adj[a].add(b);
                adj[b].add(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException(String.format("���� %d ���ϸ�", v));
        }
    }
    @Override
    public int getV() {
        return V;
    }
    @Override
    public int getE() {
        return E;
    }

    // �ж�����ָ���Ķ���֮���Ƿ��б�
    // ʱ�临�Ӷȣ�O(logV)
    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        return adj[v].contains(w);
    }

    // ��ȡָ�������������ڵĶ���
    // ʱ�临�Ӷȣ�O(1)
    @Override
    public Collection<Integer> adj(int v) {
        validateVertex(v);

        return adj[v];
    }

    // ��ȡָ������Ķ���
    @Override
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("������ = %d������ = %d \n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjSet adjList = new AdjSet("data/graph");
        System.out.println(adjList);
    }
}

